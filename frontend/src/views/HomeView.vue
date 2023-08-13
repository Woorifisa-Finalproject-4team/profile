<script setup>
import { RouterLink, RouterView } from 'vue-router'
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
</template>