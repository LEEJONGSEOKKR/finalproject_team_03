import {useState, useEffect} from 'react'
import {Bar, Doughnut, Line, Radar} from 'react-chartjs-2'
import './Contents.css';
import axios from 'axios'
import arrayData from "./price.json"
console.log(arrayData);

const Contents = () => {



    const [confirmedData, setConfirmedData] = useState({})
    const [quarantienedData, setQuarantienedData] = useState({})
    const [comparedData, setComparedData ] = useState({})

    // useEffect(()=>{
    //     const fetchEvents = async() => {
    //         const res = await axios.get("https://api.covid19api.com/total/dayone/country/Kr")
    //         makeData(res.data)
    //     }
    //     const makeData = (items)=>{
    //         const arr = items.reduce((acc, cur) => {
    //             const currentDate = new Date(cur.Date);
    //             const year = currentDate.getFullYear();
    //             const month = currentDate.getMonth();
    //             const date = currentDate.getDate();
    //             const confirmed = cur.Confirmed;
    //             const active = cur.Active;
    //             const death = cur.Deaths;
    //             const recovered = cur.Recovered;
                
    //             const findItem = acc.find(a=> a.year === year && a.month === month);

    //             if(!findItem){
    //                 acc.push({year, month, date, confirmed, active, death, recovered})
    //             }
    //             if(findItem && findItem.date < date){
    //                     findItem.active = active;
    //                     findItem.death = death;
    //                     findItem.date = date;
    //                     findItem.year = year;
    //                     findItem.month = month;
    //                     findItem.recovered = recovered;
    //                     findItem.confirmed = confirmed;
    //             }
                
    //             return acc;
    //         }, [])
    //         // const labels = arr.map(a=>`${a.month+1}월`);
    //         // setConfirmedData({
    //         //     labels,
    //         //     datasets: [
    //         //         {
    //         //                 label: "국내 누적 확진자", 
    //         //                 backgroundColor: "salmon",
    //         //                 fill: true,
    //         //                 data: arr.map(a=> a.confirmed)
    //         //         },
    //         //     ]
    //         // });

    //         // setQuarantienedData({
    //         //     labels,
    //         //     datasets: [
    //         //         {
    //         //                 label: "월별 격리자 현황", 
    //         //                 borderColor: "salmon",
    //         //                 fill: false,
    //         //                 data: arr.map(a=> a.active)
    //         //         },
    //         //     ]
    //         // });

    //         // const last = arr[arr.length -1]
    //         // console.log(arr);
    //         // setComparedData({
    //         //     labels: ["확진자", "격리해제", "사망"],
    //         //     datasets: [
    //         //         {
    //         //                 label: "누적 확진, 해제, 사망 비율",
    //         //                 backgroundColor: ["#ff3d67", "#059bff", "#ffc233"], 
    //         //                 borderColor: ["#ff3d67", "#059bff", "#ffc233"],
    //         //                 fill: false,
    //         //                 data: [last.confirmed, last.recovered, last.death]
    //         //         },
    //         //     ]
    //         // });

    //     }

    //     fetchEvents()

    // }, [])
    
    const newArrayData = arrayData.map((item, index)=>{
        return (
            <li key={index}>
                {item.Date}({item.Open}) from {item.Data}
            </li>
        );
    });

    const labes = newArrayData
    setConfirmedData({
        datasets:[
        {   
            label: "삼성 주식  현황",
            backgroundColor: "salmon",
            fill: true,
            data: labes.map(a=>a.high)
        },
    ]
});

    return (
        <section>
        <h2>국내 주식 주가 차트</h2>
        <div className="contents">
            <div className="charts">
                    <Bar data={confirmedData} options={
                        {title: {display:true, text: "실시간 차트", fontSize: 16}},
                        {legend: {display:true, position: "bottom"}}
                    }/>
            </div>

            <div className="charts">
                    <Line data={quarantienedData} options={
                        {title: {display:true, text: "국내 주식 현황", fontSize: 16}},
                        {legend: {display:true, position: "bottom"}}
                    }/>
            </div>

            <div className="charts">
                    <Doughnut data={comparedData} options={
                        {title: {display:true, text: "국외 주식 현황(${new Date().getMonth()+1)월", fontSize: 16}},
                        {legend: {display:true, position: "bottom"}}
                    }/>
            </div>

            <div className="charts">
                    <Radar data={comparedData} options={
                        {title: {display:true, text: "국외 주식 현황(${new Date().getMonth()+1)월", fontSize: 16}},
                        {legend: {display:true, position: "bottom"}}
                    }/>
            </div>
        </div>
  </section>
    )
}

export default Contents
