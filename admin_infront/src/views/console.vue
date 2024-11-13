<template>
  <el-card>
    <div id="echarts-box" style="width: 100%; height: 400px;"></div>
  </el-card>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: 'MyChart',
  mounted() {
    this.initChart();
  },
  methods: {
    initChart() {
      const chart = echarts.init(document.getElementById('echarts-box'));
      const options = {
        title: {
          text: '示例折线图'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          data: ['一月', '二月', '三月', '四月', '五月', '六月']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '销量',
            type: 'line',
            data: [120, 200, 150, 80, 70, 110],
            smooth: true
          }
        ]
      };
      chart.setOption(options);
    }
  }
};
</script>

<style scoped>
/* 你可以在这里添加样式 */
</style>
