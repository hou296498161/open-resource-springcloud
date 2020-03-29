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
                        prop="id"
                        label="id"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="apiName"
                        label="API名称">
                </el-table-column>
                <el-table-column
                        prop="name"
                        label="serverId"
                       >
                </el-table-column>

                <el-table-column
                        prop="path"
                        label="地址">
                </el-table-column>
                <el-table-column
                        prop="stripPrefix"
                        label="是否去前缀">
                </el-table-column>
                <el-table-column
                        prop="retryable"
                        label="是否重连">
                </el-table-column>
                <el-table-column
                        prop="enabled"
                        label="启用状态">
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
                this.$ZuulRouter.queryAllZuulRouter().then(resp=>{

                    this.tableData=JSON.parse(resp.data.data);
                    console.log("执行：：",this.tableData)
                }).catch(e=>{
                    this.$message.error("出现错误"+e.message);
                })
            }
        }
    }
</script>

<style scoped>

</style>
