<h1>Requirements</h1>
<ol><li>Docker Community Edition</li></ol>
<h1>How to run</h1>
<ol>
    <li>clone the repository</li>
    <li>./run.sh</li>
</ol>

### Networking
- Inspect a container and get IP address of the network which this container is using
- now use this ip address instead of local host

### Note
 - Use
    ```
    spring.rabbitmq.addresses=amqp://rabbitmq:5672/
    ```