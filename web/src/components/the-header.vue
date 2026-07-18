<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        v-model:selectedKeys="selectedKeys1"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="1" style="left: 150px">nav 1</a-menu-item>
      <a-menu-item key="2" style="left: 150px">nav 2</a-menu-item>
      <a-menu-item key="3" style="left: 150px">nav 3</a-menu-item>
    </a-menu>
  </a-layout-header>
</template>
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'the-header',

});
</script>
