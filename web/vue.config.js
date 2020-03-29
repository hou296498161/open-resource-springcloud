// vue.config.js
const path = require('path')
const webpack = require('webpack')
const version = new Date().getTime();

function resolve(dir) {
	return path.join(__dirname, dir)
}
module.exports = {
	// 基本路径
	// 将部署应用程序的基本URL。
	// 默认情况下，Vue CLI假设您的应用程序将部署在域的根目录下。
	// https://www.my-app.com/。如果应用程序部署在子路径上，则需要使用此选项指定子路径。例如，如果您的应用程序部署在https://www.foobar.com/my-app/，集baseUrl到'/my-app/'.
	publicPath: './',
	//在npm run build时 生成文件的目录 type:string, default:'dist'
	//outputDir: 'dist',
	// 默认在生成的静态资源文件名中包含hash以控制缓存
	filenameHashing: true,
	// 生产环境是否生成 sourceMap 文件
	productionSourceMap: false,
	// eslint-loader 是否在保存的时候检查
	lintOnSave: true,
	//解决vue.runtime.common.js",改为引用代码中的引用vue.esm.js文件,避免报错
	runtimeCompiler: true,

	css: {
		// 是否使用css分离插件
		extract: false,
		// 是否为 CSS 开启 source map。设置为 true 之后可能会影响构建的性能
		sourceMap: false
	},
	//设置代理
	devServer: {
		proxy: {
			'/beauhou': {
				target: ' http://localhost:1000/',
				changeOrigin: true,
				pathRewrite: {
					'^/beauhou': ''
				}
			},
		},
	}
}
