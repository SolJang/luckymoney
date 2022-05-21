<template>
  <div>
    <div id="sample">{{sample}}</div>
    <button @click="moveHelloWorld()">helloworld 페이지로 이동</button>
    <br />
    <br />
    <button @click="moveLoopSample()">moveLoopSample 페이지로 이동</button>
    <br />
    <br />
    <button @click="moveServerSample()">클릭하면 서버통신</button>
  </div>
</template>

<script>
import {getAxiosWithMessage} from "../../public/static/js/request";
import {TEST_URL} from "../../public/static/js/api";
import {SERVICE_ERROR} from "../../public/static/js/msg";

export default {
  name: "MainPage",
  data() {
    return {
      sample: "변경 전 입니다.",
    };
  },

  /**
   * Vue 인스턴스가 초기화된 직후 발생하며 아직 DOM이 그려지지않은 시점이다.
   * data에도 접근 불가
   */
  beforeCreate() {
    console.log("beforeCreate");
    if (document.querySelector("#sample")) {
      console.log("beforeCreate have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  /**
   * data에 접근가능하나, 아직 DOM이 완벽히 그려지지는 않은 상태
   * 초기 data 값 셋팅이나 비동기 작업의 시작, 이벤트 리스너 선언은 created에서 해주는 것이 좋다.
   */
  created() {
    console.log("created");
    setTimeout(() => {
      this.sample = "변경 후 입니다.";
    }, 2000);

    if (document.querySelector("#sample")) {
      console.log("created have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  /**
   * 가상 DOM이 생성되어 실제 DOM에 부착하기 전 단계
   */
  beforeMount() {
    console.log("beforeMount");
    if (document.querySelector("#sample")) {
      console.log("beforeMount have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  /**
   * 가상 DOM이 생성되어 실제 DOM에 부착되고 난 후 실행되는 훅 3
   *
   * 모든 ELE
   */
  // dom element 생성 후 실행되는 함수 -> element 조작이나 element 값을 가져와서 작업을 수행해야하는 경우 mounted를 사용
  mounted() {
    console.log("mounted");
    this.$nextTick(() => {
      if (document.querySelector("#sample")) {
        console.log("mounted have sample element!");
        console.log("access state", this.sample);
        console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
      }
    });
  },
  beforeUpdate() {
    console.log("beforeUpdate");
    if (document.querySelector("#sample")) {
      console.log("beforeUpdate have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  // 상태 (data)가 변경된 이후 실행되는 함수
  updated() {
    console.log("updated");
    if (document.querySelector("#sample")) {
      console.log("updated have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  beforeDestroy() {
    console.log("beforeDestroy");
    if (document.querySelector("#sample")) {
      console.log("beforeDestroy have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  destroyed() {
    console.log("destroyed");
    if (document.querySelector("#sample")) {
      console.log("destroyed have sample element!");
      console.log("access state", this.sample);
      console.log("innerHTML: ", document.querySelector("#sample").innerHTML);
    }
  },
  methods: {
    moveHelloWorld() {
      this.$router.push({
        path: "/helloWorld",
        //query
      });
    },
    moveLoopSample() {
      this.$router.push({
        path: "/loop",
        //query
      });
    },
    moveServerSample: async function() {
      let params = {
        id : "0101111",
        name : "jangsol"
      }

      console.log("params : ", params);
      await getAxiosWithMessage(
        TEST_URL,
        params,
        res => {
          console.log(res);
          if(res.status === 0 ){
            alert("[" + res.message + "] " + res.result);
          }
        },
        err => {
          console.log(err);
          alert(SERVICE_ERROR);
        }
      )
    }
  },
};
</script>

<style>
</style>