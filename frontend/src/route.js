import Vue from "vue";
import VueRouter from "vue-router";

import HelloWorldPage from "./views/HelloWorldPage";
import LoopExamplePage from "@/views/LoopExamplePage";
import MainPage from "@/views/MainPage";

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: "history", // default는 hash 모드이다. history 모드를 적용하지 않으면 localhost:8080/#/ 이렇게 표시된다.
    routes: [
        {
            path: "/main",
            component: MainPage,
            alias: ["/m", "/"]
        },
        {
            path: "/helloworld",
            component: HelloWorldPage
        },
        {
            path: "/loop",
            component: LoopExamplePage
        },
    ]
});