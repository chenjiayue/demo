<template>
  <a-layout-header class="header">


  </a-layout-header>
</template>
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'the-header',
  props: {
    msg: String,
  },
});
</script>