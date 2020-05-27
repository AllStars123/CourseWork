<script>
    import {doQuery} from '../utils.js';
    import {onMount} from 'svelte';

    export let id;

    let diagnos;

    let mounted = false;

    let name = '';

    onMount(async () => {
        doQuery(`/diagnos/${id}`)
                .then(response => response.json())
                .then(json => {
                    diagnos = json;
                    mounted = true;
                });
    });

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
        });

        doQuery(`/diagnos/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }
</script>

{#if mounted}
    <form on:submit={handleSubmit}>
        <div class="form-group">
            <label for="nameInput">Name</label>
            <input type="text"
                   id="nameInput"
                   class="form-control"
                   aria-describedby="emailHelp"
                   placeholder="{diagnos.name}"
                   required
                   bind:value={name}>
        </div>

        <button type="submit" class="btn btn-primary">Создать</button>
    </form>
{/if}

<style>

</style>