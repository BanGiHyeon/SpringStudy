<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
a.link:hover{
   cursor:pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- 
   Model = ViewModel = View(HTML) => MVVM
      =======================> 기능으로 설정 (양방향 통신)
 -->
</head>
<body>
  <jsp:include page="${login_jsp }"></jsp:include>
  <div class="container" id="listApp">
    <div class="row">
      <div class="col-md-3" v-for="vo in food_list">    <!-- 루프돌아가는곳 설정 잘하기 -->
       <div class="thumbnail">
       <a :href="'../food/detail.do?fno='+vo.fno">
        <img :src="'https://www.menupan.com/'+vo.poster" style="width:100%">
         <!--  블록을 열고닫지못해서  :찍어야됨 -->
         <div class="caption">
           <p style="font-size: 8px">{{vo.name}}</p>
         </div>
        </div>
       </a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
       <ul class="pagination">
        <li v-if="startPage>1"><a class="link" @click="prev()">&laquo;</a></li>
        <li v-for="i in range(startPage,endPage)" :class="curpage===i?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
        <li v-if="endPage<totalpage"><a class="link" @click="next()">&raquo;</a></li>
       </ul>
      </div>
    </div>
  </div>
  <script>
  let app=Vue.createApp({
     //멤버변수 설정 => Model => 변경된 내용을 View(mount에 지정된 HTML)로 전송
     data(){
        return {
           food_list:[],
           curpage:1,
           totalpage:0,
           startPage:0,
           endPage:0
        }
     },
     // ViewModel => 기능 처리  ===> Model에 있는 데이터값(상태)에 변경
     mounted(){
        // 시작과 동시에 데이터 처리
        this.dataRecv()
     },
     methods:{
        // 사용자 정의 메소드 => 이벤트 처리
        //공통 사용
        dataRecv(){
            //데이터 받기
            axios.get('../food/list_vue.do',{
               params:{
                  page:this.curpage //1값 넘기며 시작
               }
            }).then(response=>{
               console.log(response.data)
                  this.food_list=response.data
            })
            
            // 페이지
            axios.get('../food/page_vue.do',{
               params:{
                  page:this.curpage
               }
            }).then(response=>{
               console.log(response.data)
                  this.curpage=response.data.curpage;
               this.totalpage=response.data.totalpage
               this.startPage=response.data.startPage
               this.endPage=response.data.endPage
            })
        },
        range(start,end){
           let arr=[];
           let len=end-start;
           for(let i=0;i<=len;i++)
           {
              arr[i]=start;
              start++;
           }
           return arr;
        },
        prev(){
           this.curpage=this.startPage-1
           this.dataRecv()
        },
        next(){
         this.curpage=this.endPage+1
         this.dataRecv()
        },
        pageChange(page){
           this.curpage=page
           this.dataRecv()
        }
     },
     updated(){
       // 상태가 변경되었을 경우 => 데이터 (data()에 있는 데이터값이 변경)  
     }
  }).mount('#listApp')
  </script>
</body>
</html>













