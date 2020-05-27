<script>
    import {doQuery} from '../utils.js';

    let name = '';
    let max_count;

    function handleSubmit() {
        const json = JSON.stringify({
            name: name,
            max_count: max_count
        });

        doQuery('/ward', {
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
    <div class="form-group">
        <label for="countInput">Max count</label>
        <input type="number" class="form-control" id="countInput" min="0" required bind:value={max_count}>
    </div>

    <button type="submit" class="btn btn-primary">Создать</button>
</form>

<style>

</style>