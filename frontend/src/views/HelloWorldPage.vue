<template>
  <HelloWorld />
</template>

<script>
import HelloWorld from "@/components/HelloWorld";
export default {
  name: "HelloWorldPage",
  components: {
    HelloWorld,
  },
  beforeRouteEnter(to, from, next) {
    console.log("beforeRouteEnter to", to);
    console.log("beforeRouteEnter from", from);
    next();
  },
  beforeRouteLeave(to, from, next) {
    console.log("beforeRouteLeave to", to);
    console.log("beforeRouteLeave from", from);
    next();
  },
};
</script>

<style>
</style>