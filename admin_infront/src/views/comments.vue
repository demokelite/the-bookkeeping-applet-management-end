<template>
  <div>
    <ul>
      <!-- 使用 v-for 遍历数组 -->
      <li v-for="item in items" :key="item.id" >
        
		 <el-card  shadow="hover" class="card">
		      {{ item.name }} - {{ item.price }}
			   <div class="remark">{{item.id}}www{{item.currentDate}}</div>
		    </el-card>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 示例数据
      items: [
        { id: 1, name: 'Apple', price: '$1' ,currentDate:"12"},
        { id: 2, name: 'Banana', price: '$0.5' ,currentDate:"12"},
        { id: 3, name: 'Orange', price: '$0.8' ,currentDate:"12"}
      ]
    };
  }
};
</script>

<style>
.card{
	margin: 15px;
}
.remark{
	margin-left: 100rpx;
	font-size: smaller;
}
</style>
