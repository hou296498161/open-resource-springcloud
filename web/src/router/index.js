import Vue from 'vue';
import Router from 'vue-router';
Vue.use(Router);

import main from "../components/main/index"
import login from "../components/login/Login"
import zuulRouter from "@/components/router/ZuulRouter"
import application from "@/components/authenticationManager/Application"
import oauthDetails from '@/components/authenticationManager/OuathDetails'
export default new Router({
    base: process.env.BASE_URL,
    routes:[{
        path :"/main",
        name:"main",
        component:main,
        children:[
            {
                path :"/zuulRoter",
                component:zuulRouter
            },{
                path :"/application",
                component:application
            },{
                path :"/oauthDetails",
                component:oauthDetails
            }
        ]
    },{
        path :"/login",
        name:"login",
        component:login
    }]
});
