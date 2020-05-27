<script>
    import {doQuery} from '../utils.js';
    import {onMount} from 'svelte';

    let firstname = '';
    let lastname = '';
    let pathername = '';
    let diagnosID;
    let wardID;

    let diagnosList = Array();
    let wardList = Array();

    onMount(async () => {
        doQuery('/diagnos')
                .then(response => response.json())
                .then(json => {
                    diagnosList = Array.from(json);
                    diagnosID = diagnosList.length !== 0 ? diagnosList[0].id : diagnosID;
                });

        doQuery('/ward')
                .then(response => response.json())
                .then(json => {
                    wardList = Array.from(json);
                    wardID = wardList.length !== 0 ? wardList[0].id : wardID;
                })
    });

    function handleSubmit() {
        const json = JSON.stringify({
            firstname: firstname,
            lastname: lastname,
            pathername: pathername,
            diagnos: diagnosList.find(diagnos => diagnos.id === diagnosID),
            ward: wardList.find(ward => ward.id === wardID)
        });

        doQuery('/person', {
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
        <label for="firstnameInput">Firstname</label>
        <input type="text"
               id="firstnameInput"
               class="form-control"
               aria-describedby="emailHelp"
               required
               bind:value={firstname}>
    </div>

    <div class="form-group">
        <label for="lastnameInput">Lastname</label>
        <input type="text"
               id="lastnameInput"
               class="form-control"
               aria-describedby="emailHelp"
               required
               bind:value={lastname}>
    </div>

    <div class="form-group">
        <label for="pathernameInput">Pathername</label>
        <input type="text"
               id="pathernameInput"
               class="form-control"
               aria-describedby="emailHelp"
               required
               bind:value={pathername}>
    </div>

    <div class="form-group">
        <label for="imputDiagnos">Diagnos</label>
        <select id="imputDiagnos" class="form-control" bind:value={diagnosID} required>
            {#each diagnosList as diagnos}
                <option value={diagnos.id}>{diagnos.name}</option>
            {/each}
        </select>
    </div>

    <div class="form-group">
        <label for="inputWard">Ward</label>
        <select id="inputWard" class="form-control" bind:value={wardID} required>
            {#each wardList as ward}
                <option value={ward.id}>{ward.name}</option>
            {/each}
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Создать</button>
</form>

<style>

</style>