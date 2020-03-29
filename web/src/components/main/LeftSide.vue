<template>
    <el-menu
            style="height: 100%"
            default-active="2"
            class="el-menu-vertical-demo"
            :router="true"
           >
        <el-submenu index="1">
            <template slot="title">
                <i class="el-icon-location"></i>
                <span>认证中心</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="1-1">服务管理</el-menu-item>
                <el-menu-item index="application">应用管理</el-menu-item>
                <el-menu-item index="oauthDetails">令牌管理</el-menu-item>
            </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
        <template slot="title">
            <i class="el-icon-location"></i>
            <span>路由管理</span>
        </template>
        <el-menu-item-group>
            <el-menu-item index="zuulRoter">zuul路由</el-menu-item>
        </el-menu-item-group>
        </el-submenu>

    </el-menu>
</template>

<script>
    export default {
        name: "LeftSide"
    }
</script>

<style scoped>

</style>
