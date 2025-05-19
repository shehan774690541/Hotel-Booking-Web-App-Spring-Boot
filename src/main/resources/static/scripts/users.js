
const userTableBody = document.querySelector("#userDataTable tbody");

const CleanUsers = () => {
  if (userTableBody) {
    userTableBody.innerHTML = '';
  }
}

const ListUsers = async() => {
  
  CleanUsers();
  const result = await postRequest('api/users/list', null);
  var usersData = result;

  for (let i = 1; i <= usersData.data.length; i++) {
    const row = `
        <tr>
          <td>${usersData.data[i - 1].fullName}</td>
          <td>${usersData.data[i - 1].position}</td>
          <td>${userManagement(usersData.data[i - 1], i)}</td>
        </tr>
      `;
    userTableBody.innerHTML += row;
  }
}

const saveNewUsers = () => {
  const data = {
    name: document.getElementById('username').value,
    password: document.getElementById('password').value,
    position: document.getElementById('position').value,
  };
  postRequest('/user/new', data)
    .then(result => console.log('Result:', result))
    .catch(err => console.warn('POST Error:', err));

  ListUsers();
}

const deleteTheUser = (i) => {
  const data = {
    id: i
  }
  postRequest('api/users/delete', data)
    .then(result => console.log('Result:', result))
    .catch(err => console.warn('POST Error:', err));

  ListUsers();
}

const userManagement = (usrDta, i) => {
  // if (usrDta.position == 'Manager') {
  // return "<button class='btn btn-sm btn-secondary' disabled>Cannot Delet</button>";
  // } else{
  return `<button  onclick='deleteTheUser(${i})' class='btn btn-sm btn-danger'>Delete</button>`;
  // }
};
