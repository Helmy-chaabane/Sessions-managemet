import React, { Fragment } from "react";
import Trash from "../../assets/svgs/Trash";
import Edit from "../../assets/svgs/Edit";
import DeleteModel from "../Model/DeleteModel";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import "../Buttons/button.scss";
import "./list.scss";

const List = ({
  items,
  titles,
  name,
  path,
  handleDelete,
  unDeleteble,
  setModelComponent,
}) => {
  const history = useHistory();
  const handleEdit = (id) => {
    history.push(`${path}/EDIT/${id}`);
  };

  const showDeleteModel = (id) => {
    setModelComponent(<DeleteModel deleteObj={() => handleDelete(id)} />);
  };

  return (
    <Fragment>
      {!unDeleteble && (
        <Link to={`${path}/ADD`} className="btn btn__link">
          {name}
        </Link>
      )}

      <table className="list">
        <thead>
          <tr>
            {titles.map((title, index) => (
              <th key={index}>{title.name}</th>
            ))}
            {!unDeleteble && <th className="list__action">action</th>}
          </tr>
        </thead>
        <tbody>
          {items.map((item) => (
            <tr key={item.id}>
              {titles.map((title, index) => (
                <td key={index}>{item[title.label]}</td>
              ))}
              {!unDeleteble && (
                <td className="list__icons">
                  <Edit
                    className=" list__icon list__icon--edit"
                    handleEdit={handleEdit}
                    id={item.id}
                  />

                  <Trash
                    className=" list__icon list__icon--trash"
                    showDeleteModel={showDeleteModel}
                    id={item.id}
                  />
                </td>
              )}
            </tr>
          ))}
        </tbody>
      </table>
    </Fragment>
  );
};

export default List;
