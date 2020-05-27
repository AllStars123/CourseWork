<script>
    import {link} from "svelte-routing";
    import {USER} from '../store.js';

    $: route = document.location.pathname.substr(document.location.pathname.lastIndexOf("/"));

</script>


<nav class="navbar navbar-dark bg-danger navbar-expand-lg">
    <a class="navbar-brand" href="/">Hell Hospital</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="" id="navbarNav">
        <ul class="navbar-nav">
            {#if $USER !== null}

                <li class="nav-item {route === 'wards' ? 'active' : ''}">
                    <a class="nav-link" href="/wards" use:link>Ward</a>
                </li>

                <li class="nav-item {route === 'diagnosis' ? 'active' : ''}">
                    <a class="nav-link" href="/diagnosis" use:link>Diagnos</a>
                </li>

                <li class="nav-item {route === 'people' ? 'active' : ''}">
                    <a class="nav-link" href="/people" use:link>Person</a>
                </li>
            {/if}
        </ul>
    </div>
    <span class="authBlock">
            {#if $USER !== null}
                <a class="nav-link text-light" href="/logout">Logout</a>
            {:else}
                <a class="nav-link text-light" href="/registration" use:link>Registration</a>
                <a class="nav-link text-light" href="/login">Login</a>
            {/if}
    </span>
</nav>

<style>
    .authBlock {
        display: grid;
        grid-auto-flow: column;
        justify-content: left;
        align-content: center;
        margin-left: auto;
    }
</style>