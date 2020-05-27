<script>
    import {doQuery} from '../utils.js';

    let username = '';
    let password = '';

    function handleSubmit() {
        const json = JSON.stringify({
            username: username,
            password: password,
            roles: ['USER']
        });

        doQuery('/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });
    }
</script>

<div class="container center">
    <form on:submit={handleSubmit}>
        <div class="form-group">
            <label for="usernameInput">Username</label>
            <input type="text" class="form-control" id="usernameInput" placeholder="Username" required bind:value={username}>
        </div>
        <div class="form-group">
            <label for="passwordInput">Password</label>
            <input type="password" class="form-control" id="passwordInput" placeholder="Another input" required
                   bind:value={password}>
        </div>
        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>

    </form>
</div>


<style>
    .center {
        margin: auto;
    }
</style>