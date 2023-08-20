import { useEffect, useState } from "react";
import { BarChart, Bar, XAxis, YAxis, Tooltip } from "recharts";
import { Price } from "./price";

const width = window.innerWidth;
const height = window.innerHeight;

const Chart = () => {
    const [prices, setPrices] = useState<Price[]>([]);

    useEffect(() => { prices.length < 1 && fetchData() }, []);

    const fetchData = async () => {
        try {
            const response = await fetch("http://localhost:8081/TodayAndDayForward");
            const data = await response.json();
            setPrices(data);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <div style={{ width: '10vh' }} >
            <BarChart width={width - 100} height={height - 100} data={prices} margin={{ left: 50 }}>
                <YAxis />
                <XAxis dataKey="hour" />
                <Tooltip />
                <Bar dataKey="PriceNoTax" fill="#8884d8" />
                <Bar dataKey="PriceWithTax" fill="#82ca9d" />
            </BarChart>
        </div>
    )



}

export default Chart;