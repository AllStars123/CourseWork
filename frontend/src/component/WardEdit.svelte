<script>
    import {onMount} from 'svelte';
    import {doQuery} from '../utils.js';

    export let id;
    export let ward;

    let name = '';
    let max_count;

    let mounded = false;

    onMount(async () => {
        doQuery(`/ward/${id}`)
                .then(response => response.json())
                .then(json => {
                    ward = json;
                    mounded = true;
                });
    });

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
            max_count: max_count
        });

        doQuery(`/ward/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }
</script>


{#if mounded}
    <form on:submit={handleSubmit}>
        <div class="form-group">
            <label for="nameInput">Name</label>
            <input type="text"
                   id="nameInput"
                   class="form-control"
                   aria-describedby="emailHelp"
                   placeholder="{ward.name}"
                   required
                   bind:value={name}>
        </div>
        <div class="form-group">
            <label for="countInput">Max count</label>
            <input type="number" class="form-control" id="countInput" min="0" placeholder="{ward
            .max_count}" required
                   bind:value={max_count}>
        </div>

        <button type="submit" class="btn btn-primary">Изменить</button>
    </form>
{/if}

<style>

</style>