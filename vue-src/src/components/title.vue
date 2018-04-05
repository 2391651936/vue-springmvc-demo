<template>
    <div>
        <p class="firstTitle">{{name}}</p>
    </div>
</template>

<script>
    export default {
    	name: 'firstTitle',
        props: ["name"],
        data () {
    		return {

            };
        }
    }
</script>

<style>
    .firstTitle{
        font-size: 1.3em;
        font-weight: bold;
    }
</style>