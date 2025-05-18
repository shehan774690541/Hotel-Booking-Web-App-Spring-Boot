const baseUrl = 'api/users/list';

async function postRequest(url, data) {
  try {
    const response = await fetch(`${url}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const responseData = await response.json();
    return {
      data: responseData,
      statusCode: 200,
    };
  } catch (error) {
    console.warn("There was an error with the POST request:", error);
    return {
      error: error.message,
      statusCode: 500,
    };
  }
}
