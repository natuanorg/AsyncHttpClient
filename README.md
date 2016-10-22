# AsyncHttpClient
Simple Asynchronous HTTP Library for Android
# Usage

```java
try {
    HTTPRequest.Builder builder = new HTTPRequest.Builder();
    builder.setVerb(HTTPRequest.Verb.GET);
    builder.setUrl("http://jsonplaceholder.typicode.com/users");
    HTTPRequest request = builder.build();
    AsyncHttpClient client = new AsyncHttpClientImpl();
    client.excuteAsync(request, jsonResponseHandler);
} catch (Exception ex) {
    ex.printStackTrace();
}

private JsonResponseHandler<ResponseType, ErrorType> jsonResponseHandler =
    new JsonResponseHandler<ResponseType, ErrorType>(
            new TypeToken<ResponseType>() {
            }.getType(),
            new TypeToken<ErrorType>() {
            }.getType()
    ) {
        @Override
        public void onSuccess(ResponseType response) {
          // Do something with the Response
          // ...
        }

        @Override
        public void onFailure(ErrorType response) {
          // Something wrong happened.
        }

        @Override
        public void onError(Throwable error) {
          // Something wrong happened.
        }
    };
```
