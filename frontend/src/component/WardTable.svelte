<script>
    import {link} from "svelte-routing";
    import {doQuery} from '../utils.js';
    import {onMount} from 'svelte';

    let mounded = false;
    let wardList = Array();

    onMount(async () => {
        doQuery('/ward')
                .then(response => response.json())
                .then(json => {
                    wardList = Array.from(json);
                });
    });

    function handleDelete(id) {
        doQuery(`/ward/${id}`, {
            method: 'DELETE'
        })
                .then(response => {
                    wardList = wardList.filter(ward => ward.id !== id);
                })
    }
</script>


<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Max Count</th>
        </tr>
        </thead>
        <tbody>
        {#each wardList as ward}
            <tr>
                <td>{ward.name}</td>
                <td>{ward.max_count}</td>
                <td><a href="/wards/{ward.id}" use:link>Edit</a></td>
                <td><a href="#" on:click={() => handleDelete(ward.id)}>Delete</a></td>
            </tr>
        {/each}
        </tbody>
    </table>
</div>

<style>


</style>