<template>
  <div class="home">
    <a-button danger ghost>Danger</a-button>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
    {{ebooks}}
  </div>

</template>
<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import axios from 'axios';

const listData: any = [];

for (let i = 0; i < 23; i++) {
  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
  });
}

export default defineComponent({
  name: 'HomeView',
  setup(){
    console.log("setup");
    const ebooks =ref();

    onMounted(() => {
      console.log("onMounted333")
      axios.get(  "/ebook/list?name=Spring").then((response) => {
        const data = response.data;
        ebooks.value = data.content;
        console.log(response);
      });
    })
    return{
      ebooks,
      listData,
      pagination : {
        onChange: (page: any) => {
          console.log(page);
        },
        pageSize: 3,
      },
      actions: [
        { type: 'StarOutlined', text: '156' },
        { type: 'LikeOutlined', text: '156' },
        { type: 'MessageOutlined', text: '2' },
      ],


    }
  },
  components: {
    HelloWorld,
  },
});
</script>


