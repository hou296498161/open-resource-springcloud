import axios from 'axios';

const instance=axios.create({
    timeout: 10000,

});

//请求拦截器
instance.interceptors.request.use((config)=>{
    return config;
},error => {
    return Promise.reject(error);
});
//响应拦截器
instance.interceptors.response.use(resp=>{
        return resp;
},error => {
    return Promise.reject(error);
})

export default instance;
