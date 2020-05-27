<script>
    import {doQuery} from '../utils.js';

    let name = '';

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
        });

        doQuery('/diagnos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }

</script>

<form on:submit={handleSubmit}>
    <div class="form-group">
        <label for="nameInput">Name</label>
        <input type="text"
               id="nameInput"
               class="form-control"
               aria-describedby="emailHelp"
               required
               bind:value={name}>
    </div>

    <button type="submit" class="btn btn-primary">Создать</button>
</form>

<style>

</style>