<template>
  <div id="app">
    <div :class="['sidebar', { close: isSideBarClosed }]">
      <a href="#" class="logo">
        <i class="bx bx-code-alt"></i>
        <div class="logo-name"><span>Asmr</span>Prog</div>
      </a>
      <ul class="side-menu">
        <li
          v-for="(item, index) in menuItems"
          :key="index"
          :class="{ active: index === activeIndex }"
          @click="setActive(index)"
        >
          <a href="#"> <i :class="item.icon"></i>{{ item.text }} </a>
        </li>
      </ul>

      <ul class="side-menu">
        <li>
          <a href="#" class="logout">
            <i class="bx bx-log-out-circle"></i>
            Logout
          </a>
        </li>
      </ul>
    </div>
    <!-- End of Sidebar -->

    <!-- Main Content -->
    <div class="content">
      <!-- Navbar -->
      <nav>
        <i class="bx bx-menu" @click="closeToggle"></i>
        <!-- <form action="#">
          <div class="form-input">
            <input type="search" placeholder="Search..." />
            <button class="search-btn" type="submit">
              <i class="bx bx-search"></i>
            </button>
          </div>
        </form> -->
        <div class="navbar-right">
          <input
            type="checkbox"
            id="theme-toggle"
            v-model="isDarkMode"
            @change="toggleDarkMode"
            hidden
          />
          <label
            for="theme-toggle"
            class="theme-toggle"
            style="margin-right: 20px"
          ></label>
          <a href="#" class="notif" style="margin-right: 20px">
            <i class="bx bx-bell"></i>
            <span class="count">12</span>
          </a>
          <a href="#" class="profile">
            <img src="./assets/images/logo.png" />
          </a>
        </div>
      </nav>
      
      <router-view></router-view>

      <!-- End of Navbar -->

  
    </div>
  </div>
</template>



<script>
import "boxicons/css/boxicons.min.css";
import "@/assets/css/main.css";
export default {
  name: "App",
  // components: {
  //   HelloWorld
  // }

  data() {
    return {
      menuItems: [
        { icon: "bx bxs-dashboard", text: "Dashboard" ,path : "/home"},
        { icon: "bx bx-store-alt", text: "Data Collection",path:"/data" }
        // { icon: "bx bx-analyse", text: "Analytics" },
        // { icon: "bx bx-message-square-dots", text: "Tickets" },
        // { icon: "bx bx-group", text: "Users" },
        // { icon: "bx bx-cog", text: "Settings" },
      ],
      activeIndex: 2, // 设置初始活动菜单项的索引（本例中为第三项）
      isSideBarClosed: false,
      isDarkMode: false,
    };
  },
  methods: {
    setActive(index) {
      this.activeIndex = index;
      this.$router.push(this.menuItems[index].path);
    },
    closeToggle() {
      this.isSideBarClosed = !this.isSideBarClosed;
    },
    toggleDarkMode() {
      if (this.isDarkMode) {
        document.body.classList.add("dark");
      } else {
        document.body.classList.remove("dark");
      }
    },
  },
  mounted() {
    // const menuBar = document.querySelector(".content nav .bx.bx-menu");
    // const sideBar = document.querySelector(".sidebar");
    // menuBar.addEventListener("click", () => {
    //   sideBar.classList.toggle("close");
    // });
    // const searchBtn = document.querySelector(
    //   ".content nav form .form-input button"
    // );
    // const searchBtnIcon = document.querySelector(
    //   ".content nav form .form-input button .bx"
    // );
    // const searchForm = document.querySelector(".content nav form");
    // searchBtn.addEventListener("click", function (e) {
    //   if (window.innerWidth < 576) {
    //     e.preventDefault;
    //     searchForm.classList.toggle("show");
    //     if (searchForm.classList.contains("show")) {
    //       searchBtnIcon.classList.replace("bx-search", "bx-x");
    //     } else {
    //       searchBtnIcon.classList.replace("bx-x", "bx-search");
    //     }
    //   }
    // });
    // window.addEventListener("resize", () => {
    //   if (window.innerWidth < 768) {
    //     sideBar.classList.add("close");
    //   } else {
    //     sideBar.classList.remove("close");
    //   }
    //   if (window.innerWidth > 576) {
    //     searchBtnIcon.classList.replace("bx-x", "bx-search");
    //     searchForm.classList.remove("show");
    //   }
    // });
    // const toggler = document.getElementById("theme-toggle");
    // toggler.addEventListener("change", function () {
    //   if (this.checked) {
    //     document.body.classList.add("dark");
    //   } else {
    //     document.body.classList.remove("dark");
    //   }
    // });
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap");
@import url("./assets/css/main.css");
</style>
