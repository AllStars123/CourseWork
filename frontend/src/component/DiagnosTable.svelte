<script>
    import {link} from 'svelte-routing';
    import {doQuery} from '../utils.js';
    import {onMount} from 'svelte';

    let diagnosList = Array();

    onMount(async () => {
        doQuery('/diagnos')
                .then(response => response.json())
                .then(json => {
                    diagnosList = Array.from(json);
                });
    });

    function handleDelete(id) {
        doQuery(`/diagnos/${id}`, {
            method: 'DELETE'
        }).then(() => {
            diagnosList = diagnosList.filter(diagnos => diagnos.id !== id);
        });
    }
</script>


<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        {#each diagnosList as diagnos}
            <tr>
                <td>{diagnos.name}</td>
                <td><a href="/diagnosis/{diagnos.id}" use:link>Edit</a></td>
                <td><a href="#" on:click={() => handleDelete(diagnos.id)}>Delete</a></td>
            </tr>
        {/each}
        </tbody>
    </table>
</div>


<style>

</style>