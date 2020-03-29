<template>
    <el-container style="height: 100%;padding: 10px" >
        <el-header style="padding: 0;height: 30px;padding-left: 20px">
            <el-form :inline="true">
                <el-form-item label="API名称">
                    <el-input  placeholder="API名称 " size="small" clearable>
                        <i class="el-icon-search" slot="suffix" @click="">
                        </i>
                    </el-input>
                </el-form-item>
                <el-form-item label="serverId">
                    <el-input  placeholder="serverId " size="small"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button icon="el-icon-search" type="primary" size="small">查询</el-button>
                </el-form-item>

            </el-form>
        </el-header>
        <el-main>
            <el-table
                    :data="tableData"
                    border
                    style="width: 100%">
                <el-table-column
                        prop="instanceId"
                        label="instanceId"
                        width="250"
                        >
                </el-table-column>
                <el-table-column
                        prop="sid"
                        label="sid">
                </el-table-column>
                <el-table-column
                        prop="app"
                        label="app">
                </el-table-column>
                <el-table-column
                        prop="ipAddr"
                        label="IP地址"
                       >
                </el-table-column>

                <el-table-column
                        prop="homePageUrl"
                        label="首页地址">
                </el-table-column>
                <el-table-column
                        prop="status"

                        label="状态">
                </el-table-column>


                <el-table-column
                        prop="hostName"
                        label="hostName">
                </el-table-column>
            </el-table>
        </el-main>
        <el-footer>
            <el-pagination
                    background
                    style="float: right"
                    :current-page="1"
                    :page-sizes="[100, 200, 300, 400]"
                    :page-size="100"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="this.tableData.length">
            </el-pagination>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        data() {
            return {
                tableData: []
            }
        },
        created(){
            this.initData();
        },
        methods:{
            // handleSizeChange(val) {
            //     console.log(`每页 ${val} 条`);
            // },
            // handleCurrentChange(val) {
            //     console.log(`当前页: ${val}`);
            // },
            initData(){
                this.$Authentication.getAllApplicationInfo().then(resp=>{
                    console.log(resp.data)
                    this.tableData=[];
                    resp.data.forEach(val=>{
                        this.tableData.push(val.instanceInfo)
                    })
                }).catch(e=>{
                    this.$message.error("出现错误"+e.message);
                })
            }
        }
    }
</script>

<style scoped>

</style>
