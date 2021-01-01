<template>
  <v-app>
    <div id="app">
      <img alt="logo" src="./assets/fLogo.png" width="100px"
           onclick="window.location.reload()">
      <v-card>
        <v-app-bar
            color=#4DA6EA
            dark
            dense>
          <v-spacer>
            <v-toolbar-title justify-center >낙 시 조 아</v-toolbar-title>
          </v-spacer>
        </v-app-bar>
      </v-card>

      <fishing
          v-bind:propsData="items"
          @searchName="searchName"
          @getFiliter="findByFilter">

      </fishing>

    </div>

  </v-app>
</template>

<script>

import fishing from "@/components/fishing";
import axios from "axios";

export default {
  name: 'App',

  data() {
    return {
      items: '',
      filterItems: [],
      typeString: '',
      loading: false,

    }
  },

  components: {
    'fishing': fishing
  },

  methods: {
    startApp() {
      axios.get('/api/list').then(res => {
        console.log(res);
        this.items = res;
      })
      console.log("start!");
    },
    searchName(items) {
      console.log(items.name);
      axios.get('/api/fisher/name/' + items.name).then(res => {
        console.log(res);
        this.items = res;
      })
    },

    findByFilter(items) {
      this.typeString = '';

      if (items.place != null)
        this.typeString += "place";
      if (items.fish != null)
        this.typeString += "fish";
      if (items.detail != null)
        this.typeString += "detail";
      if (items.type != null)
        this.typeString += "type";
      if (items.fName != null)
        this.typeString += "name";

      axios.get('/api/findd',
          {
            params: {
              place: items.place,
              fish: items.fish,
              type: this.typeString,
              place2: items.detail,
              fisherType: items.type,
              name: items.fName
            }
          }).then(res => {
        console.log(res);
        this.items = res;
        this.loading = false;
        console.log("then ! " + " " + this.loading);
      })
      this.loading = true;
      console.log("after! " + " " + this.loading);
    },


  },
  created() {
    this.startApp();
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  padding: 0;
  height: 100%;
  margin-top: 20px;
  min-height: 100%;
}
</style>