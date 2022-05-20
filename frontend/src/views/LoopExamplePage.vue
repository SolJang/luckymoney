<template>
  <ul>
    <item v-for="(item,idx) in list" :key="item.id" :item="item" :idx="idx" />
  </ul>
</template>

<script>
import Item from "@/components/Item";
export default {
  name: "LoopExample",
  components: {
    Item,
  },
  data() {
    return {
      list: [
        {
          id: "user1",
          text: "하",
        },
        {
          id: "user2",
          text: "이",
        },
        {
          id: "user3",
          text: "요",
        },
      ],
    };
  },
};
</script>

<style>
</style>