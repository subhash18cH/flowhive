import { BrowserRouter, Route, Routes } from "react-router-dom"
import LandingPage from "./components/LandingPage"
import SignUp from "./components/auth/SignUp"
import SignIn from "./components/auth/SignIn"
import UserProfile from "./components/UserProfile"
import ProtectedRoute from "./components/ProtectedRoute"
import { SidebarProvider } from "@/components/ui/sidebar";
import Profile from "./components/Profile"
import Settings from "./components/Settings"
import Matches from "./components/Matches"
import Partner from "./components/Partner"
import { Toaster } from "react-hot-toast";
import ClickedProfileInfo from "./components/ClickedProfileInfo"
const App = () => {
  return (
    < >

      <BrowserRouter>
        <Toaster
          position="top-center"
          reverseOrder={false}
        />
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/signin" element={<SignIn />} />

          <Route path="/user-profile" element={
            <ProtectedRoute>
              <UserProfile />
            </ProtectedRoute>
          } />

          <Route path="/profile" element={
            <SidebarProvider>
              <ProtectedRoute>
                <Profile />
              </ProtectedRoute>
            </SidebarProvider>
          } />
          <Route path="/settings" element={
            <SidebarProvider>
              <ProtectedRoute>
                <Settings />
              </ProtectedRoute>
            </SidebarProvider>
          } />
          <Route path="/matches" element={
            <SidebarProvider>
              <ProtectedRoute>
                <Matches />
              </ProtectedRoute>
            </SidebarProvider>
          } />
          <Route path="/partner" element={
            <SidebarProvider>
              <ProtectedRoute>
                <Partner />
              </ProtectedRoute>
            </SidebarProvider>
          } />
          <Route path="/p/:profile" element={
            <SidebarProvider>
              <ProtectedRoute>
                <ClickedProfileInfo />
              </ProtectedRoute>
            </SidebarProvider>
          } />

        </Routes>
      </BrowserRouter>


    </>
  )
}
export default App