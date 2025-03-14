import { BrowserRouter, Route, Routes } from "react-router-dom"
import LandingPage from "./components/LandingPage"
import SignUp from "./components/auth/SignUp"
import SignIn from "./components/auth/SignIn"
import UserProfile from "./components/UserProfile"

const App = () => {
  return (
    < >
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LandingPage/>}/>
          <Route path="/signup" element={<SignUp/>}/>
          <Route path="/signin" element={<SignIn/>}/>
          <Route path="/profile" element={<UserProfile/>}/>
        </Routes>
      </BrowserRouter>
      
    </>
  )
}
export default App