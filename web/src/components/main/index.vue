<template>
    <div style="height: 100%;width: 100%;" >
        <el-header style="height: 50px;background-color: cadetblue">
            <open-head></open-head>
        </el-header>
        <el-container>

            <el-container :style="{height:height+'px',overflowX:'hidden'}">
                <el-scrollbar style="height: 100%;">
                    <el-aside style="width: 180px;overflow-x: hidden;height: 100%;">
                        <left-side></left-side>
                    </el-aside>
                </el-scrollbar>
                <el-container>
                        <open-main style="height: 100%" ></open-main>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    import OpenHead from './head'
    import LeftSide from './LeftSide'
    import OpenMain from './Main'
    import OpenFoot from './Foot'
    export default {
        name: "Main",
        components:{
            OpenHead,
            LeftSide,
            OpenMain,
            OpenFoot
        },
        mounted: function () {

        },
        data() {
            return {
                height: (document.body.clientHeight || document.documentElement.clientHeight) - 50,
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                            label: '三级 1-1-1'
                        }]
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                            label: '三级 2-1-1'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                            label: '三级 2-2-1'
                        }]
                    }]
                }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1',
                        children: [{
                            label: '三级 3-1-1'
                        }]
                    }, {
                        label: '二级 3-2',
                        children: [{
                            label: '三级 3-2-1'
                        }]
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
            }
        }
    }
</script>
<style>

    .el-scrollbar__wrap {
        overflow-x: hidden;
    }
</style>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }


    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
</style>
