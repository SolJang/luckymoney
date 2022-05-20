<template>
  <li>
    id: {{item.id}}
    <br />
    text: {{item.text}}
  </li>
</template>

<script>
export default {
  name: "Item",
  props: {
    item: {
      type: Object,
      required: true,
    },
    idx: {
      type: Number,
      required: true,
    },
  },
};
</script>

<style>
</style>
