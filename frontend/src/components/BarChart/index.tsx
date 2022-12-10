import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleVisitsAndDealsBySeller } from '../../types/sale';
import { round } from '../../utils/math';
import { BASE_URL } from '../../utils/request';


type SeriesData = {
    name: string,
    data: number[];
}

type BarChartData = {
    labels: {
        categories: string[];
    },
    series: SeriesData[];
}

const BarChart = () => {

    const [barChartData, setBarChartData] = useState<BarChartData>(
        {
            labels: {
                categories: []
            },
            series: [{name: "% Sucesso", data: []}]
        });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/visits-and-deals-by-seller`)
            .then(response => {
                const visitsAndDealsBySeller = response.data as SaleVisitsAndDealsBySeller[];

                let chartCategories = visitsAndDealsBySeller.map(element => element.sellerName)
                let chartSeries = visitsAndDealsBySeller.map(element => round((element.totalOfDeals / element.totalOfVisit) * 100, 1))

                console.log(chartCategories, chartSeries)
                setBarChartData( {
                    labels: {
                        categories: chartCategories
                    },
                    series: [{name: "% Sucesso", data: chartSeries}]});
            });

    }, []);


    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: barChartData.labels }}
            series={barChartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;

