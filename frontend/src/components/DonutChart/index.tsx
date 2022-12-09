import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { BASE_URL } from '../../utils/request';
import { SaleSum } from '../../types/sale';

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(response => {
                const data = response.data as SaleSum[];
                let chartLabels = data.map(saleSum => saleSum.sellerName);
                let chartSeries = data.map(saleSum => saleSum.sum);

                setChartData({ labels: chartLabels, series: chartSeries });
            });
    }, []);

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;

