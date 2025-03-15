import React from 'react'
import MySideBar from './MySideBar'

const Partner = () => {
  const handleClick=()=>{
    
  }
  return (
    <>
      <div>
        <MySideBar />
      </div>
      <div className='w-full'>
        <div className='flex flex-col justify- items-center mt-36'>
          <div className='mb-16 flex flex-col gap-2'>
            <h1 className='text-4xl font-bold'>FlowHive Matcher</h1>
            <span className='text-gray-600'>Swipe and ❤️ your perfect business partner</span>
        
          </div>

          <div>
            <h1 className='text-2xl font-bold text-center'>Who are you looking for?</h1>
            <span className='text-gray-500'>Choose the type of partner you want to collaborate with</span>
          </div>

          <div className='flex gap-5 mt-10'>
            <button onClick={handleClick} className='border rounded-xl bg-yellow-400 hover:bg-yellow-300 py-3 px-8'>Developers</button>
            <button onClick={handleClick} className='border rounded-xl bg-yellow-400 hover:bg-yellow-300 py-3 px-8'>Marketers</button>
          </div>
        </div>
      </div>
    </>
  )
}

export default Partner