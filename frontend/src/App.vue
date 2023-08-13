<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios'
import {ref} from 'vue'

const userName = ref(0);
const userId = ref(0);
const servicePurpose = ref(0);
const userAgeGroup = ref(0);
const asset = ref(0);


 axios.get("http://localhost:8080/1/profile")
    .then(response => {
      // Get 요청 성공 시 로직
      console.log(response.data);
      // 서버로부터 받은 결과 값을 표시
      userName.value = response.data.name;
      userId.value = response.data.userId;
      // servicePurpose.value = response.data.servicePurpose;
      if(response.data.servicePurpose == 'FORCAR'){
        servicePurpose.value = '자동차 사기';
      }
      if(response.data.userAgeGroup = 'THREE'){
        userAgeGroup.value = '30대';
      } 
      asset.value = response.data.asset;
    })
    // POST 요청 실패 시 로직
    .catch(error => {
      console.error(error);
    });

</script>

<template>
<div class="container">
 
<div class="card mb-3" style="max-width: 800px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="https://picsum.photos/id/873/600/850" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">{{userName}} 고객님 환영합니다!</h5>
        <p class="card-text">{{userId}}</p>
        <p class="card-text">이용목적 : {{servicePurpose}}</p>
        <p class="card-text">연령대 : {{userAgeGroup}}</p>
        <p class="card-text">현재 자산 : {{asset}} </p>
        <button type="button" class="btn btn-outline-info">Edit</button>
        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
</div>

</div>

<!--
  <header>
    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>
    
  </header>
  <RouterView />
-->
  
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
