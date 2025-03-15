import React from 'react'
import MySideBar from './MySideBar'
import { useNavigate } from 'react-router-dom'

const Settings = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem("JWT")
    navigate("/")
  }
  return (
    <>
      <div >
        <MySideBar />
      </div>

      <div className=' w-full mt-20'>
        <h1 className='text-3xl font-bold'>Settings</h1>
        <div className='mt-8'>
          <h1 className='text-2xl font-semibold mb-10'>Account</h1>
          <button onClick={handleLogout} className='border px-4 py-2 rounded-xl bg-orange-500 hover:bg-orange-600 text-white'>Logout</button>
        </div>
        <div className='mt-16'>
          <h1 className='text-2xl text-red-600 font-semibold mb-2'>Danger Zone</h1>
          <button className='text-red-600 text-xs'>Delete Account</button>
        </div>
      </div>
    </>
  )
}
export default Settings