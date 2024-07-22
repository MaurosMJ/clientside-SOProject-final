# Final Operating Systems (OS) Project

###### @Author: MaurosMJ

<div style="text-align:center;">
    <img src="https://imgur.com/O8Cy2wQ.png" alt="FX Logo" width="100" height="100">
</div>

> **⚠️ NOTE: This project is currently under development and is not yet completed.**

This repository contains my final work for the operating systems course. It essentially involves overloading a container (Docker) with CPU, memory, and disk usage, while one service performs various calculations and another service monitors resource consumption. The main idea is for the operating system to be so overloaded that the calculations start producing incorrect results.

**Technologies:**

- Java Swing
- Docker
- Apache Tomcat

## Index

- [Overview](#overview)
- [Worknotes & Commits](#worknotes--commits)
- [Credits](#credits)

## Overview

For this project, Docker was used, and the chosen operating system was Alpine due to its lightness, simplicity, and ease of use. On the server side, there are three main services:
 
<div style="text-align:center;">
    <img src="https://imgur.com/P0CqxtL.png" alt="JavaFX Overview">
</div>

<div style="text-align:center;">
    <img src="https://imgur.com/tcvXv44.png" alt="JavaFX Overview">
</div>
 
- **Monitoring Service:** This service is responsible for monitoring the operating system's memory, CPU, and disk usage.
  - **v1:** In the first version, besides monitoring, the service must return the consumption data to the client side at every '**x**' interval of time.
  - **v2:** In the second version, the information is not returned to the client side but is instead displayed on an HTML page in real-time.
 
- **Calculation Service:** This service is responsible for performing various calculations multiple times and verifying their correctness. When an incorrect result occurs, it should inform the client side of the failures.

- **Overload Service:** This service is responsible for overloading the operating system with memory, CPU, and disk usage. It also stays in a 'listening' state to respond to remote start or stop requests from the client side.

On the client side, Java Swing was used to create a graphical user interface allowing all functions to be executed remotely:
 
- **Admin Console APP:** This application functions as a control panel and can be used for one or more containers.
  - **v1:** In the first version, it is possible to monitor the resource consumption of the server-side.
  - **v2:** In the second version, this feature was removed, and the port is static.

<div style="text-align:center;">
    <img src="https://imgur.com/yEEAwY7.png" alt="JavaFX Overview">
</div>

Currently, this repository is working on a second version that involves using Apache Tomcat as the application server in the container. All projects should be contained within it, and access to monitoring will be via a WEB interface. This required some changes to the project:
  
**All access will be done through port 80 (HTTP):**
  
<div style="text-align:center;">
    <img src="https://imgur.com/oavZpkh.png" alt="JavaFX Overview">
</div>
  
**The container will only have Tomcat running:**
  
<div style="text-align:center;">
    <img src="https://imgur.com/TpXtCHp.png" alt="JavaFX Overview">
</div>
  
**The graphical user interface must be redesigned:**

<div style="text-align:center;">
    <img src="https://imgur.com/7pzqHD2.png" alt="JavaFX Overview">
</div>
  
> **⚠️ NOTE: This project is currently under development and is not yet completed.**
  
## Worknotes & Commits:

##### Worknote #1 - Created GUI and Local Monitoring
Commit hash: [8953abbb128b4fba984cdd91358af3dcfe5fd7a2](https://github.com/MaurosMJ/clientside-SOProject-final/commit/8953abbb128b4fba984cdd91358af3dcfe5fd7a2)  
**Checklist:**
* **Classes created:** `Program`, `LocalMonitoring`
* **Methods created:** `getCPU`, `getMemory`, `getDisk`, `executeCommand`, `parseCpuUsage`, `parseMemoryUsage`, `parseDiskUsage`, `Main`

##### Worknote #2 - Created Overload Class
Commit hash: [89a70b3f5af32fa42be82a337bbde65c6e7b5423](https://github.com/MaurosMJ/serverside-SOProject-final/commit/89a70b3f5af32fa42be82a337bbde65c6e7b5423)  
**Checklist:**
* **Classes created:** `ResourceOverload`, `LocalMonitoring`
* **Methods created:** `main`, `overloadMemory`, `overloadDisk`, `overloadCPU`, `performMathOperations`

## Credits:
This repository is maintained by [MaurosMJ](https://github.com/MaurosMJ).
