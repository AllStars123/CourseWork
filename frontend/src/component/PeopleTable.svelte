<script>
    import {link} from "svelte-routing";
    import {doQuery} from '../utils.js';
    import {onMount} from 'svelte';

    let mounded = false;
    let personList = Array();

    onMount(async () => {
        doQuery('/person')
                .then(response => response.json())
                .then(json => {
                    personList = Array.from(json);
                });
    });

    function handleDelete(id) {
        doQuery(`/person/${id}`, {
            method: 'DELETE'
        })
                .then(response => {
                    personList = personList.filter(person => person.id !== id);
                })
    }
</script>


<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Pathername</th>
            <th scope="col">Diagnos</th>
            <th scope="col">Ward</th>
        </tr>
        </thead>
        <tbody>
        {#each personList as person}
            <tr>
                <td>{person.firstname}</td>
                <td>{person.lastname}</td>
                <td>{person.pathername}</td>
                <td>{person.diagnos.name}</td>
                <td>{person.ward.name}</td>
                <td><a href="/people/{person.id}" use:link>Edit</a></td>
                <td><a href="#" on:click={() => handleDelete(person.id)}>Delete</a></td>
            </tr>
        {/each}
        </tbody>
    </table>
</div>

<style>
</style>