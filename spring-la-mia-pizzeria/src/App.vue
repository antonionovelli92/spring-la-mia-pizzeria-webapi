<script>
import { RouterLink, RouterView } from 'vue-router'
export default {
  name: "Pizza",
  components: {}
}

</script>
<template>
  <div id="app">
    <router-link to="/">Pizza List</router-link> |
    <router-link to="/create">Create Pizza</router-link>
    <RouterView />
  </div>
</template>

<style></style>
