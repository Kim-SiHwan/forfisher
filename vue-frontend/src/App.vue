<template>
  <v-app>

    <fishing></fishing>

  </v-app>
</template>

<script>

import fishing from "@/components/fishing";

export default {
  name: 'App',

  components: {
    'fishing' : fishing
  },

  data: () => ({
    //
  }),
};
</script>
