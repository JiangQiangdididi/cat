<template>
    <div>
        <div class="top">
            <div class="top-paw">
                <img :src="pawUrl">
            </div>
            <div class="top-m">
                <div class="top-m-1">
                    <div class="top-m-1p">
                        <p>喵星人的故事</p>
                    </div>
                    <img>
                </div>
                <div class="top-m-2">
                    <p>记录喵星人</p>
                </div>
            </div>
            <div class="top-r">
                <img :src="catUrl">
            </div>
        </div>  
        <div class="content">
            <p class="content-p1">喵星人的成长故事</p>
            <div class="search">
                <div class="search-list">
                    <div class="search-left">
                        <div class="term">
                            <p>城市</p>
                            <input class="input-list">
                            <p style="margin-left:100px">年龄段</p>
                            <input class="input-list">
                        </div>
                        <div class="term">
                            <div style="width:300px;float:left">
                                <p>性别</p>
                                <input v-model="sex" class="multiselect" name="male" value="male" type="checkbox">
                                <label for="male">公猫</label>
                                <input v-model="sex" class="multiselect" name="female" value="female" type="checkbox">
                                <label for="female">母猫</label>
                                <input v-model="sex" class="multiselect" name="unknown" value="unknown" type="checkbox">
                                <label for="unknown">不明</label>
                            </div>
                            <div style="float:left;inline-height:30px;">
                                <p>健康状况</p>
                                <input v-model="health" class="multiselect" name="healthy" value="healthy" type="checkbox">
                                <label for="healthy">健康</label>
                                <input v-model="health" class="multiselect" name="normal" value="normal" type="checkbox">
                                <label for="normal">一般</label>
                                <input v-model="health" class="multiselect" name="weak" value="weak" type="checkbox">
                                <label for="weak">较弱</label>
                                <input v-model="health" class="multiselect" name="disease" value="disease" type="checkbox">
                                <label for="disease">小疾</label>
                                <input v-model="health" class="multiselect" name="cripple" value="cripple" type="checkbox">
                                <label for="cripple">残疾</label>
                            </div>
                            
                        </div>
                    </div>
                    <div class="search-right">
                        <div class="search-right-button">
                            重置
                        </div>
                        <div class="search-right-button">
                            搜索
                        </div>
                    </div>
                </div>
            </div>
            <div class="dairy">
                <div class="dairy-form">
                    <div class="dairy-form-title">
                        <img :src="pawUrl">
                        <p class="dairy-form-title-p1">标题：XXXXX</p>
                        <p class="dairy-form-title-p2">2018年7月12日 12：00</p>
                    </div>
                    <div class="dairy-form-content">
                        <p class="dairy-form-content-p1">布偶猫是全身特别松弛柔软，像软绵绵的布偶一样。该猫体型大，身体长、肌肉发达、胸部宽、颈粗而短，发育期长，幼猫要4年左右才能完全发育成熟。其特征是头大而呈楔形，头顶扁平，眼睛为深蓝色，吻部呈圆形，短鼻子上略有凹陷，有的脸上有“V”形斑纹，颈部被毛较长，属毛长猫类。</p>
                        <p class="dairy-form-content-p2">查看全文></p>
                        <img>
                    </div>
                    <div class="dairy-form-button">
                        <ul>
                            <li>
                                <img :src="likeIcon">
                                20
                            </li>
                            <li>
                                <img :src="commentIcon">
                                18
                            </li>
                            <li>
                                <img :src="collectIcon">
                                45
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="loadtips">正在加载，稍候...</div>
        </div>
        
    </div>
    
</template>

<script>
//import paw from '../assets/img/paw.jpg'
export default {
    data(){
        return{
            pawUrl:'../static/img/paw.jpg',
            catUrl:'../static/img/cat-multi.png/',
            collectIcon:'../static/img/collect-icon.png/',
            commentIcon:'../static/img/comment-icon.png/',
            likeIcon:'../static/img/like-icon.png/',
            sex:['male'],
            health:['healthy']
        }
    }
}

/* eslint-disable */
/*eslint no-trailing-spaces: "error"*/
</script>

<style scoped>
    .top{
        padding-top: 30px;
        width: 1200px;
        height: 286px;
        border-bottom: 1px solid #fc8d59; 
    }
    .top-paw{
        padding-top: 22px;
        width:32px;
        height: 264px;
        float: left;
    }
    .top-paw img{
        width: 32px;
        height: 32px;
    }
    .top-m{
        margin-left: 16px;
        width: 360px;
        height: 286px;
        float: left;
    }
    .top-m-1{
        width: 160px;
        height: 60px;
    }
    .top-m-1p{
        height: 24px;
        padding-top: 20px;
        font-weight: 500;
        font-size: 24px;
        font-family:'PingFang';
    }
    .top-m-1 img{
        margin-top: 30px;
        margin-left: 30px;
        width: 100px;
        height: 100px;
        background-color: #ecc6c6;
        float: left;;
        border-radius: 50%;
    }
    .top-m-2{
        float: left;
        margin-top: 30px;
        margin-left: 30px;
        width: 200px;
        height: 60px;
        background-color: #fc8d59;
        border-radius: 5px;
        text-align: center;
        line-height: 60px;
    }
    .top-m-2 p{
        font-weight: 500;
        font-size: 24px;
        font-family:'PingFang';
        color: #fff;
    }
    .top-r{
        float: right;
        margin-right: 10px; 
        width: 100px;
        height: 286px;
    }
    .top-r img{
        width: 100px;
        height: 270px;
    }
    .content{
        width: 1200px;
        margin-top: 50px;
    }
    .content-p1{
        margin-left: 50px;
        font-weight: 500;
        font-size: 24px;
        font-family:'PingFang';
    }
    .search{
        height: 100px;
    }
    .search p{
        font-weight: 550;
        font-size: 20px;
        font-family:'PingFang';
        color: #4575b4;
        float: left;
        margin-left: 10px;
    }
    .input-list{
        border: 1px solid #91bfdb;
        border-radius: 10px;
        width: 150px;
        height: 30px;
        float: left;
        margin-left: 10px;
        text-align: center;
        font-weight: 550;
        font-size: 18px;
        font-family:'PingFang';
        color: #000;
    }
    .search-left{
        width: 750px;
        height: 100px;
        float: left;
    }

    .search-right{
        width: 50px;
        height: 100px;
        float: right;
        margin-right: 100px;
    }
    .term{
        width: 750px;
        padding-top: 20px;
        height: 30px;
        line-height: 30px;
    }
    .multiselect{
        font-size: 14px;
        margin-left: 10px;
        margin-top: 5px;
        width: 20px;
        height: 20px;
        border-radius: 5px;
        border:none;
        background-color: #e0f3f8;
    }
    .term label{
        font-size: 14px;
        color: #d0dcec;
    }
    .search-right-button{
        width: 48px;
        height: 28px;
        border-radius: 5px;
        border: 1px solid #fc8d59;
        margin: 10px 0 10px 0;
        float: right;
        line-height: 30px;
        text-align: center;
        font-weight: 500;
        font-size: 14px;
        font-family:'PingFang';
        color: #fc8d59
    }
    .dairy{
        width: 1000px;
        margin-top: 50px;
        margin-left: 100px;
    }
    .dairy-form{
        width: 998px;
        height: 248px;
        border:1px solid #cccccc;
        border-radius: 5px;
        margin-top: 30px;
    }
    .dairy-form-title{
        height: 20px;
        line-height: 20px;
        margin:10px 0 10px 0;
    }
    .dairy-form-title img{
        width: 20px;
        height: 20px;
        float: left;
    }
    .dairy-form-title-p1{
        width: 774px;
        margin-left: 5px;
        font-weight: 500;
        font-size: 20px;
        font-family:'PingFang';
        color: #333333;
        float: left;
    }
    .dairy-form-title-p2{
        margin-right: 15px;
        width: 183px;
        font-weight: 500;
        font-size: 12px;
        font-family:'PingFang';
        color: #a0a0a0;
        text-align: right;
        float: left;
    }
    .dairy-form-content{
        width: 950px;
        height: 180px;
        margin: 0 19px 0 29px;
    }
    .dairy-form-content-p1{
        width: 720px;
        height: 150px;
        margin-top: 10px;
        font-weight: 500;
        font-size: 14px;
        font-family:'PingFang';
        color: #333333;
        float: left;
    }
    .dairy-form-content-p2{
        width: 720px;
        height: 20px;
        font-weight: 500;
        font-size: 14px;
        font-family:'PingFang';
        color: #fc8d59;
        text-align: right;
        float: left;
    }
    .dairy-form-content img{
        width: 180px;
        height: 180px;
        margin-left: 50px;
        border-radius: 5px;
        float:none;
        background: #4575b4;
    }
    .dairy-form-button{
        width: 998px;
        height: 29px;
    }
    .dairy-form-button li{
        width: 100px;
        height: 29px;
        line-height: 29px;
        font-weight: 500;
        font-size: 12px;
        font-family:'PingFang';
        color: #a0a0a0;
        text-align: left;
        float: right;
    }
    .dairy-form-button li img{
        width: 20px;
        height: 20px;
        margin-top: 5px;
    }
    .loadtips{
        width: 998px;
        height: 28px;
        margin-left: 100px;
        margin-top: 13px;
        border-radius: 5px;
        border: 1px solid #fc8d59;
        font-weight: 500;
        font-size: 14px;
        font-family:'PingFang';
        color: #fc8d59;
        text-align: center;
        line-height: 28px;
    }
</style>


