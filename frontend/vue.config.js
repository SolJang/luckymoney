module.exports = {
    //빌드 타켓 디렉토리, vue.js 빌드 결과물을 spring boot 서버쪽에 만들도록 설정
    outputDir: "../src/main/resources/static",
    devServer: {
        proxy: {
            '/api': {   // api로 들어오면 포트 80(스프링서버)로 보낸다
                target: 'http://localhost:80',
                changeOrigin: true // cross origin 허용
            }
        }
    }
}