<!--<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view/>

</template>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
-->
<!--<template>
  <div id="components-slider-demo-mark">
    <h4>included=true</h4>
    <a-slider :marks="marks" v-model:value="value1" />
    <a-slider range :marks="marks" v-model:value="value2" />

    <h4>included=false</h4>
    <a-slider :marks="marks" :included="false" v-model:value="value3" />

    <h4>marks & step</h4>
    <a-slider :marks="marks" :step="10" v-model:value="value4" />

    <h4>step=null</h4>
    <a-slider :marks="marks" :step="null" v-model:value="value5" />
  </div>
</template>
<script lang="ts">
import { defineComponent, createVNode, ref } from 'vue';

export default defineComponent({
  setup() {
    const value1 = ref<number>(37);
    const value2 = ref<number[]>([26, 37]);
    const value3 = ref<number>(37);
    const value4 = ref<number>(37);
    const value5 = ref<number>(37);
    const marks = ref<Record<number, any>>({
      0: '0°C',
      26: '26°C',
      37: '37°C',
      100: {
        style: {
          color: '#f50',
        },
        label: createVNode('strong', {}, '100°C'),
      },
    });

    return {
      value1,
      value2,
      value3,
      value4,
      value5,
      marks,
    };
  },
});
</script>
<style scoped>
#components-slider-demo-mark h4 {
  margin: 0 0 16px;
}
#components-slider-demo-mark .ant-slider-with-marks {
  margin-bottom: 44px;
}
</style>-->
<template>
  <a-layout id="components-layout-demo-top-side-2">
    <the-header></the-header>
    <!--<router-view/>-->
    <the-footer></the-footer>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import TheHeader from '@/components/the-header.vue';
import TheFooter from '@/components/the-footer.vue';

export default defineComponent({
  name: 'app',
  components: {
    TheHeader,
    TheFooter,
  },
});
</script>