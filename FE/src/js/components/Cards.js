import { useEffect, useState } from "react";
import { deleteTaskById, getAllTasks } from "../actions/TodoActions";
import Card from './Card'

const Cards = () => {

  const  fetchData = async ()=> {
    // You can await here
    const response = await getAllTasks();
    // ...
    if (response)
      dataSet(response.data);
  }
  const [data, dataSet] = useState();
  const removeItem = async (id)=>{
    await deleteTaskById(id);
    await fetchData();
  }

  useEffect(() => {
    fetchData();
  }, [])

  return (
    <>
    {/* {data && JSON.stringify(data)} */}
    {/* {data && data.map(d=>console.log(d))} */}
      {
        data ?
        
        data.map((d)=>{
            return <Card data={d} key={d.id} removeItem={removeItem}/>
          })
          
          :
          <div>Fetching......</div>
      }





      {/* {!data && <div> Fetching Data....</div>}
      { data && <div> {JSON.stringify(data)}</div>} */}
      {/* if(data){
        <div> JSON.stringify(data) </div>
      }else{
        <div> Fetching Data ..... </div>
      }
     */}
    </>
  )


}

export default Cards;