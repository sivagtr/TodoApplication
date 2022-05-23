
const Card = (props) => {
    console.log(props)
    // {id, name, description, createdAt, priority} = props;
    if(!props.data){
        return(<></>);
    }
    let {id, name, details} = props.data;
    let {description, createdAt, priority} = details;
    
    console.log(props.data);
    return (
        <>
            <button>Edit</button>
            <button onClick={props.removeItem.bind(this, id)}>Remove</button>
            <div>ID : </div>
            <div>{id}</div>
            <div>Name : </div>
            <div>{name}</div>
            <div>Description : </div>
            <div>{description}</div>
            <div>Created At : </div>
            <div>{new Date(createdAt).toDateString()}</div>
            <div>Priority : </div>
            <div>{priority}</div>

            <button>Save</button>
        </>
    )
}

export default Card;