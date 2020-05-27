<script>
    import {link} from "svelte-routing";
    export let name;

</script>


<div class="container-fluid grid">
    <div class="head">
        <h2>
            {name}
        </h2>
        <a href="{name.toLowerCase()}_create" use:link>
            Create
        </a>
    </div>

    <slot name="table">

    </slot>
</div>

<style>
    .grid {
        display: grid;
        justify-content: left;
        gap: 1em;
    }

    .head > a {
        margin-left: 1em;
    }

    h2 {
        margin-bottom: 0;
        padding-bottom: 0;
    }

</style>